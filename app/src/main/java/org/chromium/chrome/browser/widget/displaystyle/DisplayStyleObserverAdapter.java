// Copyright 2016 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.widget.displaystyle;

import android.view.View;

/**
 * Implementation of {@link DisplayStyleObserver} designed to play nicely with
 * {@link android.support.v7.widget.RecyclerView}. It will not notify of changes when the
 * associated view is not attached to the window.
 */
public class DisplayStyleObserverAdapter
        implements DisplayStyleObserver, View.OnAttachStateChangeListener {
    private final DisplayStyleObserver mObserver;

    /** Current display style, gets updated as the UiConfig detects changes and notifies us. */
    private UiConfig.DisplayStyle mCurrentDisplayStyle;

    /**
     * Latest value that we transmitted to the adapted observer. If we didn't transfer any yet,
     * the value is {@code null}.
     * @see UiConfig.DisplayStyle
     */
    private UiConfig.DisplayStyle mNotifiedDisplayStyle;

    private boolean mIsViewAttached;

    /**
     * @param view the view whose lifecycle is tracked to determine when to not fire the
     *             observer.
     * @param config the {@link UiConfig} object to subscribe to.
     * @param observer the observer to adapt. It's {#onDisplayStyleChanged} will be called when
     *                 the configuration changes, provided that {@code view} is attached to the
     *                 window.
     */
    public DisplayStyleObserverAdapter(View view, UiConfig config, DisplayStyleObserver observer) {
        mObserver = observer;

        // TODO(dgn): getParent() is not a good way to test that, but isAttachedToWindow()
        // requires API 19.
        mIsViewAttached = view.getParent() != null;

        view.addOnAttachStateChangeListener(this);

        // This call will also assign the initial value to |mCurrentDisplayStyle|
        config.addObserver(this);
    }

    @Override
    public void onDisplayStyleChanged(UiConfig.DisplayStyle newDisplayStyle) {
        assert newDisplayStyle != null;
        mCurrentDisplayStyle = newDisplayStyle;

        if (!mIsViewAttached) return;
        if (mCurrentDisplayStyle.equals(mNotifiedDisplayStyle)) return;

        mNotifiedDisplayStyle = mCurrentDisplayStyle;

        mObserver.onDisplayStyleChanged(mCurrentDisplayStyle);
    }

    @Override
    public void onViewAttachedToWindow(View v) {
        mIsViewAttached = true;
        onDisplayStyleChanged(mCurrentDisplayStyle);
    }

    @Override
    public void onViewDetachedFromWindow(View v) {
        mIsViewAttached = false;
    }
}
