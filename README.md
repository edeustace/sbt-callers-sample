## Build & run ##

There is a root project with a subproject called 'a'.

'a' depends on a library: 'lib-one'
'lib-one' depends on a library: 'lib-two'


```sh
    cd sbt-callers-issue/lib-two
    sbt publish-local
    cd ../lib-one
    sbt publish-local
    cd ..
    sbt update
```

Then have a look at the module report json in path: 

```sh
    ~/.sbt/0.13/dependency/module/dynamic/$date/$hash/a/a_2.10/0.1-SNAPSHOT_temp-resolve-$hash/graphs/graph.json
```

look at the caller list for 'scala-library' - the following callers are listed: 

* temp-resolve-$hash
* lib-one_2.10
* lib-two_2.10

lib-two could be removed as it's a transitive dependency, the caller list should only include the tmp resolve and any direct dependency.

Otherwise on a large project these json files become gigantic and slow down resolution.


