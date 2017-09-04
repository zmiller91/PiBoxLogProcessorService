/*
 * Copyright (C) 2017 zmiller
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.zm.pblpservice;

import com.zm.pblp.Api;
import static com.zm.pblp.configuration.LogChannel.LOGS;
import com.zm.pblp.model.GeneralLog;
import static com.zm.pblp.configuration.LogHost.LOCAL;
import com.zm.rabbitmqservice.RMQApplication;

/**
 *
 * @author zmiller
 */
public class Service implements Api {

    @Override
    public void log(GeneralLog message) {
        System.out.println(message.getMessage());
    }
    
    public static void main(String[] argv) throws Exception {
        String host = LOCAL.getValue();
        String channel = LOGS.getValue();
        RMQApplication.start(host, channel, new Service(), Api.class, 5);
    }
}
