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

package org.netbeans.modules.editor.errorstripe;

import java.util.List;
import org.netbeans.modules.editor.errorstripe.privatespi.MarkProvider;
import org.netbeans.spi.editor.errorstripe.UpToDateStatus;

/**
 *
 * @author Jan Lahoda
 */
public class TestMarkProvider extends MarkProvider {

    private List/*<Mark>*/ marks;
    private UpToDateStatus upToDate;

    /** Creates a new instance of TestMarkProvider */
    public TestMarkProvider(List/*<Mark>*/ marks, UpToDateStatus upToDate) {
        this.marks = marks;
        this.upToDate = upToDate;
    }

    public UpToDateStatus getUpToDate() {
        return upToDate;
    }

    public List getMarks() {
        return marks;
    }
    
    public void setMarks(List/*<Mark>*/ marks) {
        setMarks(marks, true, true);
    }
    
    public void setMarks(List/*<Mark>*/ marks, boolean fireOld, boolean fireNue) {
        List old = this.marks;
        
        this.marks = marks;
        
        firePropertyChange(PROP_MARKS, fireOld ? old : null, fireNue ? this.marks : null);
    }
    
//    public void setUpToDate(UpToDateStatus upToDate) {
//        UpToDateStatus old = this.upToDate;
//        
//        this.upToDate = upToDate;
//        
//        firePropertyChange(PROP_UP_TO_DATE, old, upToDate);
//    }
}
