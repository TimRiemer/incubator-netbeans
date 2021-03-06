/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.installer.infra.utils.style.checkers;

import java.io.File;

/**
 *
 * @author ks152834
 */
public class UnescapedStringChecker implements Checker {
    public boolean accept(final File file) {
        return file.getName().endsWith(".java"); // NOI18N
    }

    public String check(final String line) {
        if ((line.indexOf("\"") > -1) && // NOI18N
                (line.indexOf("// NOI18N") == -1)) { // NOI18N
            return "Unescaped string constant."; // NOI18N
        }
        
        return null;
    }
}
