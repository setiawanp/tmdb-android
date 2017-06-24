package com.setiawanpaiman.tmdb.android.data.source.remote;

import android.support.annotation.NonNull;

import com.setiawanpaiman.tmdb.android.data.model.Movie;
import com.setiawanpaiman.tmdb.android.data.model.MoviePaginatedList;
import com.setiawanpaiman.tmdb.android.data.source.MovieDataSource;
import com.setiawanpaiman.tmdb.android.data.viewmodel.MovieViewModel;
import com.setiawanpaiman.tmdb.android.http.api.MovieApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by Setiawan Paiman on 24/6/17.
 */

public class MovieRemoteDataSource implements MovieDataSource {

    @NonNull
    private final MovieApi mMovieApi;

    @Inject
    public MovieRemoteDataSource(@NonNull MovieApi mMovieApi) {
        this.mMovieApi = mMovieApi;
    }

    @Override
    public Observable<List<MovieViewModel>> getPopularMovies() {
        return mMovieApi.getPopularMovies()
                .map(new Function<MoviePaginatedList, List<MovieViewModel>>() {
                    @Override
                    public List<MovieViewModel> apply(@io.reactivex.annotations.NonNull MoviePaginatedList moviePaginatedList) throws Exception {
                        return moviePaginatedList.toListViewModel();
                    }
                });
    }

    @Override
    public Observable<List<MovieViewModel>> getTopRatedMovies() {
        return null;
    }
}
