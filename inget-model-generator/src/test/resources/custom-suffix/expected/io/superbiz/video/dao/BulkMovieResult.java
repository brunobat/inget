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
package io.superbiz.video.dao;

import io.superbiz.video.dao.base.bulk.Failure;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.annotation.Generated;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode
@Generated("org.tomitribe.inget.model.ModelClassGenerator")
@Schema(description = "The result of the bulk operation.")
public class BulkMovieResult {

    @Schema(description = "The movies that failed in the bulk operation.")
    private List<Failure> movies;
}
