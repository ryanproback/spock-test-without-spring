import spock.lang.Specification

class ExampleTest extends Specification {
    def "testCase"() {
        expect:
        ret == new Example().run(begin, target, words as String[])

        where:
        begin | target | words                                      || ret
        "hit" | "cog"  | ["hot", "dot", "dog", "lot", "log", "cog"] || 4
        "hit" | "cog"  | ["hot", "dot", "dog", "lot", "log"]        || 0
    }
}
