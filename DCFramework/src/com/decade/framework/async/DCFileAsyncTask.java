package com.decade.framework.async;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import android.content.Context;
import android.text.TextUtils;

import com.decade.framework.network.DCNetStatusDefine;
import com.decade.framework.network.DCNetWorkeUtility;

/**
 * @description: 文件上传
 * @author: Decade
 * @date: 2013-5-6
 * @preserve protected
 */
public abstract class DCFileAsyncTask<Params, Progress> extends
		DCBaseAsyncTask<Params, Progress> {

	/**
	 * @param taskParams
	 */
	public DCFileAsyncTask(Context context, DCAsyncTaskParams taskParams) {
		super(context, taskParams);
	}

	protected DCiResponse doUpload(String url, Map<String, String> params,
			Map<String, File> files) {
		DCiResponse result = null;
		try {
			String response_text;
			response_text = DCNetWorkeUtility.upLoadPhoto(url, params, files);
			if (!TextUtils.isEmpty(response_text)) {
				result = doJsonParse(response_text);
				senddata(DCNetStatusDefine.S_COMPLETE);
			}
		} catch (IOException e) {
			senddata(DCNetStatusDefine.S_NETWORK_ERROR);
			e.printStackTrace();
		} catch (Exception e) {
			if (e.getMessage().equals("json_parse_error")) {
				senddata(DCNetStatusDefine.S_JSON_PARSE_ERROR, e.getMessage());
			}
			e.printStackTrace();
		}

		finally {
			params.clear();
			params = null;
		}
		return result;
	}
}
