Build it: `mvn package`

## Deploy w/o version

```bash
curl -T - -u tomcat:tomcat 'http://localhost:8080/manager/text/deploy?update=true&path=/' < target/ROOT.war
```
result:

<pre>Sep 6, 2011 5:21:24 PM org.apache.catalina.startup.HostConfig deployWAR
INFO: Deploying web application archive ROOT.war
0 [Thread-13] INFO bootstrap.liftweb.Boot - Started</pre>

## Deploy with version

```bash
curl -T - -u tomcat:tomcat 'http://localhost:8080/manager/text/deploy?update=true&path=/&version=01' < target/ROOT.war
```
result:

<pre>Sep 6, 2011 5:23:12 PM org.apache.catalina.startup.HostConfig deployWAR
INFO: Deploying web application archive ROOT##01.war
1 [Thread-14] ERROR net.liftweb.http.provider.HTTPProvider - Failed to Boot! Your application may not run properly
scala.tools.nsc.MissingRequirementError: object scala not found.
        at scala.tools.nsc.symtab.Definitions$definitions$.getModuleOrClass(Definitions.scala:517)
        at scala.tools.nsc.symtab.Definitions$definitions$.ScalaPackage(Definitions.scala:37)
        at scala.tools.nsc.symtab.Definitions$definitions$.ScalaPackageClass(Definitions.scala:38)
        at scala.tools.nsc.symtab.Definitions$definitions$.UnitClass(Definitions.scala:83)
        at scala.tools.nsc.symtab.Definitions$definitions$.init(Definitions.scala:789)
        at scala.tools.nsc.Global$Run.<init>(Global.scala:604)
        at com.twitter.util.Eval$StringCompiler.apply(Eval.scala:487)
        at com.twitter.util.Eval$StringCompiler$$anonfun$apply$3.apply(Eval.scala:504)
        at com.twitter.util.Eval$StringCompiler$$anonfun$apply$3.apply(Eval.scala:503)
        at scala.Option.getOrElse(Option.scala:104)
        at com.twitter.util.Eval$StringCompiler.apply(Eval.scala:503)
        at com.twitter.util.Eval.applyProcessed(Eval.scala:172)
        at com.twitter.util.Eval.applyProcessed(Eval.scala:165)</pre>

[Related discussion](https://github.com/twitter/util/issues/12)
