package io.fengfu.learning.birt;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.*;
import org.eclipse.core.internal.registry.RegistryProviderFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by fengfu.qu on 2016/7/15.
 */
public class BirtRenderTest {
    public static void main(String[] args) {
        System.out.println(executeReport());
    }

    private static String executeReport() {
        IReportEngine engine = null;
        EngineConfig config = null;

        try {
            // start up Platform
            config = new EngineConfig();
            Platform.startup(config);

            // create new Report Engine
            IReportEngineFactory factory = (IReportEngineFactory) Platform
                    .createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
            engine = factory.createReportEngine(config);

            // open the report design
            IReportRunnable design = null;
            InputStream is = ClassLoader.getSystemResourceAsStream("pf_check_stat.rptdesign");
            design = engine.openReportDesign(is);

            // create RunandRender Task
            IRunAndRenderTask task = engine.createRunAndRenderTask(design);

            // pass necessary parameters
            task.setParameterValue("p_startDate", "2016-07-11");
            task.setParameterValue("p_endDate", "2016-07-16");
            task.validateParameters();

            // set render options including output type
            HTMLRenderOption options = new HTMLRenderOption();
            ByteArrayOutputStream outs = new ByteArrayOutputStream();
            options.setOutputStream(outs);
            options.setEmbeddable(true);
            options.setOutputFormat(IRenderOption.OUTPUT_FORMAT_HTML);
            task.setRenderOption(options);

            // run task

            task.run();
            String output = outs.toString();
            task.close();
            engine.destroy();

            return output;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error";
        } finally {
            Platform.shutdown();
            RegistryProviderFactory.releaseDefault();
        }
    }
}
