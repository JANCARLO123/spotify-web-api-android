/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import me.siegenthaler.spotify.web.api.model.Page;
import me.siegenthaler.spotify.web.api.model.SimpleAlbum;

/**
 * (non-doc)
 */
public final class SearchAlbumRequest extends SearchRequest<SearchAlbumRequest, SimpleAlbum> {
    /**
     * (non-doc)
     */
    public SearchAlbumRequest() {
        setType("album");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<SimpleAlbum> getResponse() throws IOException, JSONException {

        final String data = get();
        final JSONObject object = new JSONObject(data);
        final JSONObject root = object.getJSONObject("albums");

        final List<SimpleAlbum> list = SimpleAlbum.getAllSimple(root.getJSONArray("items"));
        return new Page<>(list, root);
    }
}
