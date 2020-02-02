package interpreter;

import interpreter.bytecode.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {

        StringTokenizer token;
        Program program = new Program();
        ArrayList<String> argumentList = new ArrayList<String>();//Stores token for each line

       try {

            String nextLine = byteSource.readLine();//Store next line read from file

            while(nextLine != null) {

                argumentList.clear();//empty the list to store token from next line

                token = new StringTokenizer(nextLine);//breaks a line into parts

                //Get first token, which is a bytecode
                String classType = CodeTable.getClassName(token.nextToken());

                //store the remaining into list
                while(token.hasMoreTokens()){
                    argumentList.add(token.nextToken());
                }

                //Uses Java reflection to create an instances of specific class from the first token
                ByteCode bytecode = (ByteCode)(Class.forName("interpreter.bytecode." + classType).newInstance());

                bytecode.setArg(argumentList);
                program.addCode(bytecode);
                nextLine = byteSource.readLine();
            }

        }catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ByteCodeLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        program.resolveAddrs(program);

        return program;
    }
}

