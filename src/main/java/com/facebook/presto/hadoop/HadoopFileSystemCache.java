/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.hadoop;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.PrestoFileSystemCache;

public final class HadoopFileSystemCache
{
    private static PrestoFileSystemCache cache;

    private HadoopFileSystemCache() {}

    public static synchronized void initialize()
    {
        if (cache == null) {
            PrestoFileSystemCache newCache = new PrestoFileSystemCache();
            FileSystem.setCache(newCache);
            cache = newCache;
        }
    }
}
