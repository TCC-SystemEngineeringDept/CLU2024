/**
 * 
 */
package jp.ac.jc21.jk3a00.api.detection.response;

/**
 * @author t.yoshizawa
 * @see  * https://learn.microsoft.com/ja-jp/rest/api/language/2023-04-01/text-analysis-runtime/analyze-text?tabs=HTTP#languagedetectionresult
 */
public class LangRespResult {
	Documents[] documents;
	DocumentError[] errors;
	String modelVersion;

}
