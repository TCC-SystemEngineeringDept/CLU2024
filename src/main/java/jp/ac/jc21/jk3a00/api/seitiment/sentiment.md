# sentimentの作成について

## 公式ドキュメント

### Azure Cognitive Service for Language の感情分析について

[https://learn.microsoft.com/ja-jp/azure/cognitive-services/language-service/sentiment-opinion-mining/overview](https://learn.microsoft.com/ja-jp/azure/cognitive-services/language-service/sentiment-opinion-mining/overview)

### リクエストJSONの例

[https://learn.microsoft.com/ja-jp/azure/cognitive-services/language-service/sentiment-opinion-mining/quickstart?tabs=windows&pivots=rest-api#create-a-json-file-with-the-example-request-body](https://learn.microsoft.com/ja-jp/azure/cognitive-services/language-service/sentiment-opinion-mining/quickstart?tabs=windows&pivots=rest-api#create-a-json-file-with-the-example-request-body)



### 戻り値JSONの例

[https://learn.microsoft.com/ja-jp/azure/cognitive-services/language-service/sentiment-opinion-mining/quickstart?tabs=windows&pivots=rest-api#json-response](https://learn.microsoft.com/ja-jp/azure/cognitive-services/language-service/sentiment-opinion-mining/quickstart?tabs=windows&pivots=rest-api#json-response)

## APIリファレンス

### WebAPIのURLやヘッダーなど
* LanguageDetection、KeyPhraseExtractionと同じで大丈夫です。
* リクエストJSONのKINDによって、処理を切り分けているようです。
* 戻り値の構造も、呼び出すAPIによって変わってきます
* このフォルダに、GetKeyPhrases.javaをコピーして、必要な内容を書き換えてもらえば動くようになっています。

### リクエストJSONの形式

[https://learn.microsoft.com/ja-jp/rest/api/language/2022-10-01-preview/text-analysis-runtime/analyze-text?tabs=HTTP#analyzetextsentimentanalysisinput](https://learn.microsoft.com/ja-jp/rest/api/language/2022-10-01-preview/text-analysis-runtime/analyze-text?tabs=HTTP#analyzetextsentimentanalysisinput)

### 戻り値JSONの形式

[https://learn.microsoft.com/ja-jp/rest/api/language/2022-10-01-preview/text-analysis-runtime/analyze-text?tabs=HTTP#sentimenttaskresult](https://learn.microsoft.com/ja-jp/rest/api/language/2022-10-01-preview/text-analysis-runtime/analyze-text?tabs=HTTP#sentimenttaskresult)

### 戻り値の取得について

* results -> documents[0] -> confidenceScores の "positive"、"negative"、"neutral"を取得してください
* それ以外の項目は、取得しないで構いません。クラスに記述しなければ、JSONに内容が記載されていても、取得しません。
* 表示する場合は、"positive"、"negative"、"neutral"を、それぞれ小数点なしでパーセント表示してください。
