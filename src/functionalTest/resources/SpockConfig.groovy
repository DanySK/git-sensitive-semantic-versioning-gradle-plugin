//file:noinspection GrPackage
import org.spockframework.runtime.model.parallel.ExecutionMode

runner {
    optimizeRunOrder true
    parallel {
        enabled true
        defaultSpecificationExecutionMode ExecutionMode.CONCURRENT
        defaultExecutionMode ExecutionMode.SAME_THREAD
    }
}
