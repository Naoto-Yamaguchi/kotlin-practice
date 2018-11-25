# 11/25(日) Kotlinハッカソン
1. IntelliJ IDEAでダウンロードしたファイルをOpen
2. Dockerがインストールされてなければインストール
https://www.docker.com
3. シェルで、dockerファイルにディレクトリを移動して`docker-compose up`
4. シェルで `./gradlew clean bootRun`
5. http://localhost:8080/customers などにアクセス


## docker
1. `docker-compose ps`で動いているプロセスをみる
2. `docker-compose rm`でkill
3. `docker-compose build`
4. `docker-compose up`

## 起動
`./gradlew clean bootRun`

## postgresqlにアクセス
`docker exec -it kotlin-demo-postgres-container psql -U postgres kotlindemo`

テーブル参照 - \d


## 参考
[Spling Boot(Kotlin) 始めの一歩](https://qiita.com//Yuki10/items/aef152f300a500b85725)

[サーバーサイドKotlin(Spring Boot/Doma2)入門](https://qiita.com//maeharin/items/78325dbd629e4e6d2fdb#hello-world-%E3%81%9F%E3%81%A3%E3%81%9F3%E3%82%B9%E3%83%86%E3%83%83%E3%83%97)

[Kotlin入門](http://gihyo.jp/dev/serial/01/jvm-kotlin/0001)
