/******************************************************************************
 * Copyright © 2017 XIN Community                                             *
 *                                                                            *
 * See the AUTHORS.txt, DEVELOPER-AGREEMENT.txt and LICENSE.txt files at      *
 * the top-level directory of this distribution for the individual copyright  *
 * holder information and the developer policies on copyright and licensing.  *
 *                                                                            *
 * Unless otherwise agreed in a custom licensing agreement, no part of the    *
 * Nxt software, including this file, may be copied, modified, propagated,    *
 * or distributed except according to the terms contained in the LICENSE.txt  *
 * file.                                                                      *
 *                                                                            *
 * Removal or modification of this copyright notice is prohibited.            *
 *                                                                            *
 ******************************************************************************/
 
package xin.api;

import xin.AT;
import xin.Account;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import xin.XinException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public final class GetAllATs extends APIServlet.APIRequestHandler {

    static final GetAllATs instance = new GetAllATs();

    private GetAllATs() {
        super(new APITag[] {APITag.AT});
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest req) {

        JSONArray ats = new JSONArray();
    		for(long atId : AT.getAllATIdsSorted()) {
    			ats.add(JSONData.at(AT.getAT(atId)));
    		}

    		JSONObject response = new JSONObject();
          response.put("ats", ats);
          return response;
    }

}
