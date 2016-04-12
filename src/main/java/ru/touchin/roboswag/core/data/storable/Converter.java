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

package ru.touchin.roboswag.core.data.storable;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import ru.touchin.roboswag.core.data.exceptions.ConversionException;

/**
 * Created by Gavriil Sitnikov on 04/10/2015.
 * TODO: fill description
 */
public interface Converter<TObject, TStoreObject> {

    @Nullable
    TStoreObject toStoreObject(@NonNull Class<TObject> objectClass,
                               @NonNull Class<TStoreObject> storeObjectClass,
                               @Nullable TObject object) throws ConversionException;

    @Nullable
    TObject toObject(@NonNull Class<TObject> objectClass,
                     @NonNull Class<TStoreObject> storeObjectClass,
                     @Nullable TStoreObject storeObject) throws ConversionException;

}
