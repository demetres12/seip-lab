package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codeanalyzer.calculator.AnalysisType;
import codeanalyzer.calculator.AnalysisTypeFactory;
import codeanalyzer.exporter.MetricsExportFormatter;
import codeanalyzer.exporter.MetricsExportFormatterFactory;
import codeanalyzer.reader.FileContentReader;
import codeanalyzer.reader.FileContentReaderFactory;

/**
 * CodeAnalysisFacade serves the representation of the Facade design pattern
 * for the needs of the refactoring process. Essentially, provides a simple
 * interface to a complex subsystem which contains lots of moving parts, by
 * performing a multi-operational action.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class CodeAnalysisFacade {


    private FileContentReaderFactory fileContentReaderFactory;
    private AnalysisTypeFactory analysisTypeFactory;
    private MetricsExportFormatterFactory metricsExportFormatterFactory;

    public CodeAnalysisFacade() {
        fileContentReaderFactory = new FileContentReaderFactory();
        analysisTypeFactory = new AnalysisTypeFactory();
        metricsExportFormatterFactory = new MetricsExportFormatterFactory();
    }

    public CodeAnalysisFacade(FileContentReaderFactory fileContentReaderFactory,
                              AnalysisTypeFactory analysisTypeFactory,
                              MetricsExportFormatterFactory metricsExportFormatterFactory) {
        this.fileContentReaderFactory = fileContentReaderFactory;
        this.analysisTypeFactory = analysisTypeFactory;
        this.metricsExportFormatterFactory = metricsExportFormatterFactory;
    }

    /**
     * Accepts the arguments passed from the user to perform the necessary opoerations
     * so the give source file will be successfully read, analyzed and finally exported
     * to the requested format.
     *
     * @param filePath The provided path to the analyzed source file.
     * @param analysisType The analysisType which will be used for the metrics' calculation.
     * @param fileSourceType The source type of the given file.
     * @param outputFileName The exported output file name.
     */
    public void conductFileAnalysis(String filePath, String analysisType, String fileSourceType, String outputFileName, String outputFileType) throws IOException {

        FileContentReader fileContentReader = fileContentReaderFactory.createFileContentReader(fileSourceType);

        AnalysisType analyzer = analysisTypeFactory.createAnalysisType(analysisType);
        // An indicative implementation of the bridge pattern between FileContentReader and AnalysisType.
        analyzer.setContentReader(fileContentReader);

        // Calculates metrics following the analysisType approach (regex or stringcomp).
        int loc = analyzer.calculateLOC(filePath);
        int nom = analyzer.calculateNOM(filePath);
        int noc = analyzer.calculateNOC(filePath);

        Map<String,Integer> metrics = new HashMap<>();
        metrics.put("loc", loc);
        metrics.put("nom", nom);
        metrics.put("noc", noc);

        MetricsExportFormatter metricsExporter = metricsExportFormatterFactory.createExportFormatter(outputFileType);
        metricsExporter.writeMetrics(metrics, outputFileName);
    }
}
