
/**
 * Task 1:
 *
 * <p>Write an example program to demonstrate that
 * <blockquote><code>
 *   package com.horstmann.impatient
 * </code></blockquote>
 * is not the same as
 * <blockquote><code>
 *   package com <br/>
 *   package horstmann <br/>
 *   package impatient <br/>
 * </code></blockquote>
 *
 * @see Chapter0701a.scala  for solution part A
 * @see Chapter0701b.scala  for solution part B
 */
package com {

  object FromCom {
    val value = 1
  }

  package horstmann {

    object FromHorstmann {
      val value = 2
    }

    package impatient {

      object FromImpatient {
        val value = 3
      }
    }
  }
}

/**
 * Task 2:
 *
 * <p>Write a puzzler that baffles your Scala friends, using a package <code>com</code>
 * that isn’t at the top level.
 */
package puzzler {

  package com {
    object FromCom {
      val value = 21
    }
  }
}

/**
 * Task 3:
 *
 * <p>Write a package random with functions
 * nextInt(): Int,
 * nextDouble(): Double,
 * and setSeed(seed: Int): Unit.
 *
 * <p>To generate random numbers, use the linear congruential generator
 * next = previous × a + b mod 2n,
 * where a = 1664525, b = 1013904223, and n = 32.
 */
package object random {

  private val addition: Int = (1013904223 % (1L << 32)).toInt
  private var seed : Int = 0

  def nextInt(): Int = {
    seed = (seed * 1664525) + addition

    if (seed < 0) ~seed
    else seed
  }

  def nextDouble(): Double = {
    nextInt() / (Int.MaxValue + 1.0)
  }

  def setSeed(seed: Int): Unit = this.seed = seed
}

/**
 * Task 4:
 *
 * <p>Why do you think the Scala language designers provided the package object syntax instead
 * of simply letting you add functions and variables to a package?
 *
 * <p>Solution: <br/>
 * They decided to make it explicit by adding just one word "object" to package declaration,
 * in my opinion, for a couple of reasons:
 * <ul>
 *   <li>since its possible to have package declarations in different files, it would be hard
 *   to maintain functions and variable in different places for the same package</li>
 *   <li>because variables in package object are global (singletons) they didn't want to make it
 *   available by default</li>
 * </ul>
 */

