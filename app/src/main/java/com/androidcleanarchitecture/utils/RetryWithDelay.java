package com.androidcleanarchitecture.utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class RetryWithDelay implements Function<Observable<? extends Throwable>, Observable<?>> {
    private final int maxRetries;
    private final int retryDelayMillis;
    private int retryCount;

    public RetryWithDelay(final int maxRetries, final int retryDelayMillis) {
        this.maxRetries = maxRetries;
        this.retryDelayMillis = retryDelayMillis;
        this.retryCount = 0;
    }

    @Override
    public Observable<?> apply(@NonNull Observable<? extends Throwable> observable) throws Exception {
        return observable.flatMap((Function<Throwable, ObservableSource<?>>) throwable -> {
            if (++retryCount < maxRetries) {
                // When this Observable calls onNext, the original
                // Observable will be retried (i.e. re-subscribed).
                return Observable.timer(retryDelayMillis,
                        TimeUnit.MILLISECONDS);
            }

            // Max retries hit. Just pass the error along.
            return Observable.error(throwable);
        });
    }
}
