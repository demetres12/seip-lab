package demo;

import java.io.IOException;

import codeanalyzer.CodeAnalysisFacade;

/**
 * DemoClient is the intermediate between the client and
 * the facade code analysis class, fetching user's data and passing them
 * into the system. Hides major information from the user about the code analysis
 * processes.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class DemoClient {

	public static void main(String[] args) throws IOException {
		if(args.length != 5) {
			System.err.println("Invalid number of arguments");
			System.out.println("Execute as java -jar jar-with-dependencies arg0 arg1 arg2 arg3 arg4");
			System.out.println("arg0 = JavaSourceCodeInputFile (e.g., src/test/resources/TestClass.java)\r\n" +
					"arg1 = sourceCodeAnalyzerType [regex|strcomp]\r\n" +
					"arg2 = SourceCodeLocationType [local|web]\r\n" +
					"arg3 = OutputFilePath (e.g., ../output_metrics_file)\r\n" +
					"arg4 = OutputFileType [csv|json]\r");
			System.exit(0);
		}

		String filepath = args[0];
		String analysisType = args[1];
		String fileLocation = args[2];
		String outputFilePath = args[3];
		String outputFileType = args[4];

		CodeAnalysisFacade analyzerFacade = new CodeAnalysisFacade();
		analyzerFacade.conductFileAnalysis(filepath, analysisType, fileLocation, outputFilePath, outputFileType);
	}
}
