/*
 * Copyright (C) 2014 Siegenthaler Solutions.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.siegenthaler.spotify.web.api.request;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import me.siegenthaler.spotify.web.api.model.User;

/**
 * (non-doc)
 */
public final class UserRequest extends AbstractRequest<UserRequest, User> {
    /**
     * (non-doc)
     */
    public UserRequest() {
        setPath("/v1/me");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getResponse() throws IOException, JSONException {
        final String data = request(METHOD_GET);
        final JSONObject object = new JSONObject(data);
        return new User(object);
    }
}