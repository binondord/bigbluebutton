/*
 * BigBlueButton - http://www.bigbluebutton.org
 * 
 * Copyright (c) 2008-2009 by respective authors (see below). All rights reserved.
 * 
 * BigBlueButton is free software; you can redistribute it and/or modify it under the 
 * terms of the GNU Affero General Public License as published by the Free Software 
 * Foundation; either version 3 of the License, or (at your option) any later 
 * version. 
 * 
 * BigBlueButton is distributed in the hope that it will be useful, but WITHOUT ANY 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along 
 * with BigBlueButton; if not, If not, see <http://www.gnu.org/licenses/>.
 *
 * Author: Richard Alam <ritzalam@gmail.com>
 *
 * $Id: $x
 */
package org.bigbluebutton.deskshare.server;

import org.bigbluebutton.deskshare.server.streamer.DeskShareStream;
import org.bigbluebutton.deskshare.server.streamer.FlvStreamToFile;
import org.red5.logging.Red5LoggerFactory;
import org.red5.server.api.IScope;
import org.slf4j.Logger;

public class FrameStreamFactory {
	final private Logger log = Red5LoggerFactory.getLogger(FrameStreamFactory.class, "deskshare");
	
	private DeskShareApplication app;
	
	public IDeskShareStream createStream(String room, int screenWidth, int screenHeight) {
//		int frameRate = event.getFrameRate();
		
//		IScope scope = app.getAppScope();
		
		IScope scope = app.getAppScope().getScope(room);
/*
		if (scope == null) {
			if (app.getAppScope().createChildScope("testroom")) {
				log.debug("create child scope testroom");
				scope = app.getAppScope().getScope("testroom");
			} else {
				log.warn("Failed to create child scope testroom");
			}			
		}
*/
//		log.debug("Created stream {}", scope.getName());
		return new DeskShareStream(scope, room, screenWidth, screenHeight);
		//return new FlvStreamToFile();
	}
	
	public void setDeskShareApplication(DeskShareApplication app) {
		this.app = app;
		if (app == null) {
			log.error("DeskShareApplication is NULL!!!");
		} else {
			log.debug("DeskShareApplication is NOT NULL!!!");
		}
		
	}
}