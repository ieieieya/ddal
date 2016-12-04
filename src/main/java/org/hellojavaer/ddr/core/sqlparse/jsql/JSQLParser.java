/*
 * Copyright 2016-2016 the original author or authors.
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
package org.hellojavaer.ddr.core.sqlparse.jsql;

import net.sf.jsqlparser.util.TablesNamesFinder;
import org.hellojavaer.ddr.core.sharding.ShardingRouter;
import org.hellojavaer.ddr.core.sharding.simple.SimpleShardingRouter;
import org.hellojavaer.ddr.core.sqlparse.SqlParser;

import java.util.Map;

/**
 *
 * @author <a href="mailto:hellojavaer@gmail.com">zoukaiming[邹凯明]</a>,created on 12/11/2016.
 */
public class JSqlParser extends TablesNamesFinder implements SqlParser {

    @Override
    public String parse(String sql, Map<Integer, Object> jdbcParams, ShardingRouter shardingRouter) {
        JSQLParserAdapter sqlParser = new JSQLParserAdapter(sql, jdbcParams, shardingRouter);
        if (shardingRouter == null) {
            shardingRouter = new SimpleShardingRouter();
        }
        return sqlParser.parse();
    }

}