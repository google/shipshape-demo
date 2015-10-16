/*
 * Copyright 2015 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class PutIfAbsentIdiom {
	static Map<String, Date> chm = new ConcurrentHashMap<>();
	
	public static Date putDate(String key) {
		Date date = chm.get(key);
		if (date == null) {
			date = new Date(System.currentTimeMillis());
			chm.put(key, date);
		}
		return date;
	}
	
	public static void main(String[] args) {
		final String key = "myKey";
		Thread t1 = new Thread() {
			public void run() {
				Date date = putDate(key);
				System.out.println(date);
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				Date date = putDate(key);
				System.out.println(date);
			}
		};
		t1.start();
		t2.start();
	}
}
