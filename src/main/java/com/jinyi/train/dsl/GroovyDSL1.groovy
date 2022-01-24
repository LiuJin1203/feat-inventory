package com.jinyi.train.dsl

/**
 *
 * @author liujin
 * @since JDK8
 * @date 2022/1/13
 */
class GroovyDSL1 {

    static void main(String[] args) {
        please show the square_root of 100

        please(show).get("the")(square_root).get("of").call(100.0)
    }

    static oneWord(num) {
        please show the square_root of num
    }
    static show = { println it }
    static square_root = { Math.sqrt(it) }

    static def please(action) {
        [the  : { sqrt ->
            [of : { action("Groovy: " + sqrt(it)) },
             of2: { it -> action(sqrt(it)) }
            ]
        },
         other: { println("Hello ${it}") }
        ]
    }

}


