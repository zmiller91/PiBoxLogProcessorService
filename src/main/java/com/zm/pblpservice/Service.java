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

import com.zm.pbmessenger.PBMessengerApi;
import com.zm.pbmessenger.configuration.PBMessengerConfiguration;
import com.zm.pbmessenger.model.GeneralLog;
import com.zm.rabbitmqservice.ClientException;
import com.zm.rabbitmqservice.RMQApplication;
import com.zm.rabbitmqservice.ServiceException;

import java.util.concurrent.TimeoutException;

/**
 *
 * @author zmiller
 */
public class Service implements PBMessengerApi {

    @Override
    public GeneralLog log(GeneralLog message) throws ServiceException, ClientException {
        System.out.println(message.getMessage());
        return  message;
    }
    
    public static void main(String[] argv) throws Exception {
        String host = PBMessengerConfiguration.Host.TEST.getValue();
        String channel = PBMessengerConfiguration.Channel.TEST.getValue();
        RMQApplication.start(host, channel, new Service(), PBMessengerApi.class, 5);
    }
}
