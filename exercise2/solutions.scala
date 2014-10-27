:load lib/CDR.scala

val CDRLines = sc.textFile( "data/cdr.csv" )
val CDRsNoSite = CDRLines.map( line => CDR( line ) )

val sitesLines = sc.textFile( "data/sites.csv" )
val sites = sitesLines.map( siteLine => siteLine.split(",") )
                      .map( tokens => ( tokens(0), tokens(1) ) )

case class Site(name: String, count: Int)

val CDRs = CDRsNoSite.map( cdr => ( cdr.cell, cdr ) )
                      .join( sites )
                      .map{ case( (cell, (cdr, site) ) ) => { cdr.copy( site = site ) } }

val revenues = CDRs.map( cdr => ( cdr.a, cdr.value ) )
                .reduceByKey( (partialValue, value) => partialValue + value )

val mostUsedSites = CDRs.map( cdr => ( ( cdr.a, cdr.site ), 1) )
              .reduceByKey( (partialCount, inc) => partialCount + inc )
              .map{ case ( ( a, site ), siteCount ) => ( a, Site(site, siteCount) ) } 
              .reduceByKey( ( site1, site2 ) => if ( site1.count > site2.count ) site1 else site2)
              .mapValues( site => site.name )

val KYC = revenues.join(mostUsedSites)

KYC.sortBy(_._2._1,false).take(10)



