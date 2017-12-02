/*
 * Copyright 2017 The twicalico authors
 *
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

package com.github.moko256.twicalico.model.impl;

import android.content.ContentResolver;
import android.net.Uri;

import com.github.moko256.mastodon.MastodonTwitterImpl;
import com.github.moko256.twicalico.model.base.PostTweetModel;

import java.util.List;

import rx.Single;
import twitter4j.GeoLocation;
import twitter4j.Status;
import twitter4j.Twitter;

/**
 * Created by moko256 on 2017/10/23.
 *
 * @author moko256
 */

public class PostTweetModelCreator {
    public static PostTweetModel getInstance(Twitter twitter, ContentResolver resolver) {
        if (twitter instanceof MastodonTwitterImpl){
            return new com.github.moko256.twicalico.model.impl.mastodon.PostTweetModelImpl(((MastodonTwitterImpl) twitter).client, resolver);
        } else {
            return new com.github.moko256.twicalico.model.impl.twitter.PostTweetModelImpl(twitter, resolver);
        }
    }
}
