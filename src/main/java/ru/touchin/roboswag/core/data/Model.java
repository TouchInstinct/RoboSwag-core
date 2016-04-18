/*
 *  Copyright (c) 2015 RoboSwag (Gavriil Sitnikov, Vsevolod Ivanov)
 *
 *  This file is part of RoboSwag library.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package ru.touchin.roboswag.core.data;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import java.util.List;

import ru.touchin.roboswag.core.data.exceptions.ValidationException;

/**
 * Created by Gavriil Sitnikov on 23/03/2016.
 * TODO: description
 */
@SuppressWarnings("PMD.AbstractClassWithoutAbstractMethod")
//AbstractClassWithoutAbstractMethod: objects of this class actually shouldn't exist
public abstract class Model {

    protected static void validateList(@NonNull final List list) throws ValidationException {
        for (final Object item : list) {
            if (item instanceof Model) {
                ((Model) item).validate();
            }
        }
    }

    @CallSuper
    public void validate() throws ValidationException {
        //do nothing
    }

}
