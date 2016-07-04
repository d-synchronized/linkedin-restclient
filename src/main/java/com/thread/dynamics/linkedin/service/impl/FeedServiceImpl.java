package com.thread.dynamics.linkedin.service.impl;

import com.thread.dynamics.linkedin.resource.FeedResource;
import com.thread.dynamics.linkedin.service.BaseService;
import com.thread.dynamics.linkedin.service.FeedService;

/**
 * The Class FeedServiceImpl.
 */
public class FeedServiceImpl extends BaseService<FeedResource> implements FeedService {

    /**
     * Instantiates a new feed service impl.
     *
     * @param clazz the clazz
     */
    public FeedServiceImpl(Class<FeedResource> clazz) {
        super(clazz);
    }

}
