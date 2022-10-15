package pedro.sample.dagger2app

import dagger.Component
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import javax.inject.Inject
import javax.inject.Named


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TestMainActivity {
    @Inject lateinit var greeting1: Greeting
    @Inject @field:Named(UNSPECIFIED) lateinit var greeting2: Greeting


    @Before
    fun setup() {
        DaggerTestEtiquetteComponent
            .builder().beginModule(TestBeginModule()).build().inject(this)
    }


    @Test
    fun simpleTest() {
        assertEquals("Hello, tester!", greeting1.text)
        assertEquals("Hello, stranger!", greeting2.text)
    }
}


class TestBeginModule: BeginModule() {
    override fun sayHello(): Greeting {
        return Greeting("tester")
    }
}


@Component(modules = [BeginModule::class, FinishModule::class])
interface TestEtiquetteComponent : EtiquetteComponent {
    fun inject(app: TestMainActivity)
}
