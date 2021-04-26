# RssReadSample

はてなブックマークのRSSを取得してアプリ上で表示するAndroidの実装サンプルです。

# アーキテクチャ

MVVM+Repositoryパターンで実装しています。
はてなから読み取ったRSSはPOJO(Response)クラスに格納し、腐敗防止層によるMapperを経由してドメインモデル(ロジック/UI等で使うモデル)に変換しています。

# 使用ライブラリ
DI: [koin](https://github.com/InsertKoinIO/koin)  
Network: [Retrofit](https://github.com/square/retrofit)  
Image: [coil](https://github.com/coil-kt/coil)  
