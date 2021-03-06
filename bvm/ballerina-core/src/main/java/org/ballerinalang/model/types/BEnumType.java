/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.ballerinalang.model.types;

import org.ballerinalang.model.values.BEnumerator;
import org.ballerinalang.model.values.BValue;

/**
 * {@code BEnumType} represents the enum type in Ballerina.
 *
 * @since 0.95
 */
public class BEnumType extends BType {

    private BEnumerator[] enumerators;

    public BEnumType(String typeName, String pkgPath) {
        super(typeName, pkgPath, BEnumerator.class);
    }

    public BEnumerator getEnumerator(int index) {
        return enumerators[index];
    }

    public void setEnumerators(BEnumerator[] enumerators) {
        this.enumerators = enumerators;
    }

    @Override
    public <V extends BValue> V getZeroValue() {
        return null;
    }

    @Override
    public <V extends BValue> V getEmptyValue() {
        return null;
    }

    @Override
    public TypeSignature getSig() {
        String packagePath = (pkgPath == null) ? "." : pkgPath;
        return new TypeSignature(TypeSignature.SIG_ENUM, packagePath, typeName);
    }

    @Override
    public int getTag() {
        return TypeTags.ENUM_TAG;
    }
}
