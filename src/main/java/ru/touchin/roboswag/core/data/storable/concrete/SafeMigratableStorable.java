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

package ru.touchin.roboswag.core.data.storable.concrete;

import android.support.annotation.NonNull;

import ru.touchin.roboswag.core.data.storable.Migration;
import ru.touchin.roboswag.core.data.storable.SafeConverter;
import ru.touchin.roboswag.core.data.storable.SafeStore;
import ru.touchin.roboswag.core.utils.ObjectUtils;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;

/**
 * Created by Gavriil Sitnikov on 03/05/16.
 * TODO: description
 */
public class SafeMigratableStorable<TKey, TObject, TStoreObject>
        extends SafeStorable<TKey, TObject, TStoreObject> {

    protected SafeMigratableStorable(@NonNull final BaseBuilder<TKey, TObject, TStoreObject> builder) {
        super(builder);
    }

    @SuppressWarnings("CPD-START")
    //CPD: yes builders have copy-pasted code
    public static class Builder<TKey, TObject, TStoreObject> extends BaseBuilder<TKey, TObject, TStoreObject> {

        public Builder(@NonNull final MigratableStorable.Builder<TKey, TObject, TStoreObject> sourceBuilder) {
            super(sourceBuilder);
        }

        public Builder(@NonNull final SafeStorable.Builder<TKey, TObject, TStoreObject> sourceBuilder) {
            super(sourceBuilder);
        }

        @NonNull
        @Override
        public Migration<TKey> getMigration() {
            return ObjectUtils.getNonNull(super::getMigration);
        }

        @NonNull
        public NonNullSafeMigratableStorable.Builder<TKey, TObject, TStoreObject> setDefaultValue(@NonNull final TObject defaultValue) {
            setDefaultValueInternal(defaultValue);
            return new NonNullSafeMigratableStorable.Builder<>(this);
        }

        @NonNull
        public SafeMigratableStorable<TKey, TObject, TStoreObject> build() {
            if (!(getStore() instanceof SafeStore) || !(getConverter() instanceof SafeConverter)) {
                throw new ShouldNotHappenException();
            }
            return new SafeMigratableStorable<>(this);
        }

    }


}