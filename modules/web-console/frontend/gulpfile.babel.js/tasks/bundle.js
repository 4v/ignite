/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import gulp from 'gulp';
import webpack from 'webpack';
import webpackConfig from '../webpack';
import WebpackDevServer from 'webpack-dev-server';

gulp.task('bundle', (cb) => {
    const devServerConfig = webpackConfig.devServer;

    delete webpackConfig.devServer;

    if (process.env.NODE_ENV === 'development') {
        // Important! Call webpack and WebpackDevServer must be inline.
        new WebpackDevServer(webpack(webpackConfig), devServerConfig)
            .listen(devServerConfig.port, devServerConfig.host || 'localhost', cb);
    }
    else
        webpack(webpackConfig, cb);
});

