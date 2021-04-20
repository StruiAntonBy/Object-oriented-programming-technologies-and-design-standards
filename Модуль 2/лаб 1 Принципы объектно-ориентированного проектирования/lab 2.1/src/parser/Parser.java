package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import command.Add;
import command.Cmp;
import command.Div;
import command.In;
import command.Je;
import command.Jg;
import command.Jl;
import command.Jmp;
import command.Jne;
import command.Jng;
import command.Jnl;
import command.Mov;
import command.Mul;
import command.Out;
import command.Sub;
import data.Variable;
import data.WorkListVariables;

public class Parser implements ParserInterface{
	
	private BufferedReader reader;
	private ArrayList<Variable> variables;
	private int specvar=-10;
	
	public void parse(File file) {
		try {
			FileReader fr= new FileReader(file);
			reader = new BufferedReader(fr);
			String line=reader.readLine();
			int numberLine = 1;
			variables=new ArrayList<Variable>();
			while(line!=null) {
				line=line.trim();
				String[] words = line.split(" ");
				if(words.length==2) {
					int index=WorkListVariables.getIndex(variables, words[1]);
					switch(words[0]) {
						case In.Name:
							if(index==-1) {
								Variable obj=new Variable();
								if(obj.setName(words[1])) {
									obj.setValue(In.getValue());
									variables.add(obj);
								}
								else {
									System.out.println("Error name variable: line " + numberLine);
									return;
								}
							}
							else {
								variables.get(index).setValue(In.getValue());
							}
							break;
						case Out.Name:
							if(index==-1) {
								System.out.println("Error no such variable: line " + numberLine);
								return;
							}
							else {
								Out.setValue(variables.get(index).getValue());
							}
							break;
						case Jmp.Name:
							int jmpLine;
							if(index==-1) {
								try {
									Variable a=new Variable();
									a.setValue(Double.parseDouble(words[1]));
									jmpLine=Jmp.getValue(a);
								}
								catch(NumberFormatException e) {
									System.out.println("Error operand1 is not a number and is not a variable: line " + numberLine);
									return;
								}
							}
							else {
								jmpLine=Jmp.getValue(variables.get(index));
							}
							if(jmpLine>numberLine) {
								int skip=jmpLine-numberLine;
								while(skip>1) {
									line=reader.readLine();
									skip-=1;
								}
							}
							else if(jmpLine==numberLine) {
								System.out.println("Error circularity: line " + numberLine);
								return;
							}
							else {
								fr= new FileReader(file);
								reader=new BufferedReader(fr);
								numberLine=0;
								int i=0;
								while(jmpLine-1>i) {
									line=reader.readLine();
									i=i+1;
								}
							}
							break;
						case Je.Name:
							int jeLine;
							if(index==-1) {
								try {
									Variable a=new Variable();
									a.setValue(Double.parseDouble(words[1]));
									jeLine=Je.getValue(a,specvar);
								}
								catch(NumberFormatException e) {
									System.out.println("Error operand1 is not a number and is not a variable: line " + numberLine);
									return;
								}
							}
							else {
								jeLine=Je.getValue(variables.get(index),specvar);
							}
							if(jeLine==-1) {
								break;
							}
							else if(jeLine==-10) {
								System.out.println("Error missing value in a special variable: line " + numberLine);
								return;
							}
							else if(jeLine>numberLine) {
								int skip=jeLine-numberLine;
								while(skip>1) {
									line=reader.readLine();
									skip-=1;
								}
							}
							else if(jeLine==numberLine) {
								System.out.println("Error circularity: line " + numberLine);
								return;
							}
							else {
								fr= new FileReader(file);
								reader=new BufferedReader(fr);
								numberLine=0;
								int i=0;
								while(jeLine-1>i) {
									line=reader.readLine();
									i=i+1;
								}
							}
							break;
						case Jne.Name:
							int jneLine;
							if(index==-1) {
								try {
									Variable a=new Variable();
									a.setValue(Double.parseDouble(words[1]));
									jneLine=Jne.getValue(a,specvar);
								}
								catch(NumberFormatException e) {
									System.out.println("Error operand1 is not a number and is not a variable: line " + numberLine);
									return;
								}
							}
							else {
								jneLine=Jne.getValue(variables.get(index),specvar);
							}
							if(jneLine==-1) {
								break;
							}
							else if(jneLine==-10) {
								System.out.println("Error missing value in a special variable: line " + numberLine);
								return;
							}
							else if(jneLine>numberLine) {
								int skip=jneLine-numberLine;
								while(skip>1) {
									line=reader.readLine();
									skip-=1;
								}
							}
							else if(jneLine==numberLine) {
								System.out.println("Error circularity: line " + numberLine);
								return;
							}
							else {
								fr= new FileReader(file);
								reader=new BufferedReader(fr);
								numberLine=0;
								int i=0;
								while(jneLine-1>i) {
									line=reader.readLine();
									i=i+1;
								}
							}
							break;
						case Jg.Name:
							int jgLine;
							if(index==-1) {
								try {
									Variable a=new Variable();
									a.setValue(Double.parseDouble(words[1]));
									jgLine=Jg.getValue(a,specvar);
								}
								catch(NumberFormatException e) {
									System.out.println("Error operand1 is not a number and is not a variable: line " + numberLine);
									return;
								}
							}
							else {
								jgLine=Jg.getValue(variables.get(index),specvar);
							}
							if(jgLine==-1) {
								break;
							}
							else if(jgLine==-10) {
								System.out.println("Error missing value in a special variable: line " + numberLine);
								return;
							}
							else if(jgLine>numberLine) {
								int skip=jgLine-numberLine;
								while(skip>1) {
									line=reader.readLine();
									skip-=1;
								}
							}
							else if(jgLine==numberLine) {
								System.out.println("Error circularity: line " + numberLine);
								return;
							}
							else {
								fr= new FileReader(file);
								reader=new BufferedReader(fr);
								numberLine=0;
								int i=0;
								while(jgLine-1>i) {
									line=reader.readLine();
									i=i+1;
								}
							}
							break;
						case Jng.Name:
							int jngLine;
							if(index==-1) {
								try {
									Variable a=new Variable();
									a.setValue(Double.parseDouble(words[1]));
									jngLine=Jng.getValue(a,specvar);
								}
								catch(NumberFormatException e) {
									System.out.println("Error operand1 is not a number and is not a variable: line " + numberLine);
									return;
								}
							}
							else {
								jngLine=Jng.getValue(variables.get(index),specvar);
							}
							if(jngLine==-1) {
								break;
							}
							else if(jngLine==-10) {
								System.out.println("Error missing value in a special variable: line " + numberLine);
								return;
							}
							else if(jngLine>numberLine) {
								int skip=jngLine-numberLine;
								while(skip>1) {
									line=reader.readLine();
									skip-=1;
								}
							}
							else if(jngLine==numberLine) {
								System.out.println("Error circularity: line " + numberLine);
								return;
							}
							else {
								fr= new FileReader(file);
								reader=new BufferedReader(fr);
								numberLine=0;
								int i=0;
								while(jngLine-1>i) {
									line=reader.readLine();
									i=i+1;
								}
							}
							break;
						case Jl.Name:
							int jlLine;
							if(index==-1) {
								try {
									Variable a=new Variable();
									a.setValue(Double.parseDouble(words[1]));
									jlLine=Jl.getValue(a,specvar);
								}
								catch(NumberFormatException e) {
									System.out.println("Error operand1 is not a number and is not a variable: line " + numberLine);
									return;
								}
							}
							else {
								jlLine=Jl.getValue(variables.get(index),specvar);
							}
							if(jlLine==-1) {
								break;
							}
							else if(jlLine==-10) {
								System.out.println("Error missing value in a special variable: line " + numberLine);
								return;
							}
							else if(jlLine>numberLine) {
								int skip=jlLine-numberLine;
								while(skip>1) {
									line=reader.readLine();
									skip-=1;
								}
							}
							else if(jlLine==numberLine) {
								System.out.println("Error circularity: line " + numberLine);
								return;
							}
							else {
								fr= new FileReader(file);
								reader=new BufferedReader(fr);
								numberLine=0;
								int i=0;
								while(jlLine-1>i) {
									line=reader.readLine();
									i=i+1;
								}
							}
							break;
						case Jnl.Name:
							int jnlLine;
							if(index==-1) {
								try {
									Variable a=new Variable();
									a.setValue(Double.parseDouble(words[1]));
									jnlLine=Jnl.getValue(a,specvar);
								}
								catch(NumberFormatException e) {
									System.out.println("Error operand1 is not a number and is not a variable: line " + numberLine);
									return;
								}
							}
							else {
								jnlLine=Jnl.getValue(variables.get(index),specvar);
							}
							if(jnlLine==-1) {
								break;
							}
							else if(jnlLine==-10) {
								System.out.println("Error missing value in a special variable: line " + numberLine);
								return;
							}
							else if(jnlLine>numberLine) {
								int skip=jnlLine-numberLine;
								while(skip>1) {
									line=reader.readLine();
									skip-=1;
								}
							}
							else if(jnlLine==numberLine) {
								System.out.println("Error circularity: line " + numberLine);
								return;
							}
							else {
								fr= new FileReader(file);
								reader=new BufferedReader(fr);
								numberLine=0;
								int i=0;
								while(jnlLine-1>i) {
									line=reader.readLine();
									i=i+1;
								}
							}
							break;
						default:
							System.out.println("Error command: line " + numberLine);
							return;
						}
				}
				else if(words.length==3) {
					words[1]=words[1].substring(0,words[1].length()-1);
					int index=WorkListVariables.getIndex(variables, words[1]);
					switch(words[0]) {
						case Mov.Name:
							if(index==-1) {
								Variable obj=new Variable();
								obj.setName(words[1]);
								int index2=WorkListVariables.getIndex(variables, words[2]);
								if(index2==-1) {
									try {
										obj.setValue(Double.parseDouble(words[2]));
									}
									catch(NumberFormatException e) {
										System.out.println("Error operand2 is not a number and is not a variable: line " + numberLine);
										return;
									}
									variables.add(obj);
								}
								else {
									obj=Mov.getVariable(obj, variables.get(index2));
									variables.add(obj);
								}
							}
							else {
								int index2=WorkListVariables.getIndex(variables, words[2]);
								if(index2==-1) {
									try {
										variables.get(index).setValue(Double.parseDouble(words[2]));
									}
									catch(NumberFormatException e) {
										System.out.println("Error operand2 is not a number and is not a variable: line " + numberLine);
										return;
									}
								}
								else {
									variables.add(index,Mov.getVariable(variables.get(index), variables.get(index2)));
								}
							}
							break;
						case Add.Name:
							if(index==-1) {
								System.out.println("Error operand1 unknown variable: line " + numberLine);
								return;
							}
							else {
								int index2=WorkListVariables.getIndex(variables, words[2]);
								if(index2==-1) {
									try {
										variables.get(index).setValue(variables.get(index).getValue()+Double.parseDouble(words[2]));
									}
									catch(NumberFormatException e) {
										System.out.println("Error operand2 is not a number and is not a variable: line " + numberLine);
										return;
									}
								}
								else {
									variables.add(index,Add.getVariable(variables.get(index), variables.get(index2)));
								}
							}
							break;
						case Sub.Name:
							if(index==-1) {
								System.out.println("Error operand1 unknown variable: line " + numberLine);
								return;
							}
							else {
								int index2=WorkListVariables.getIndex(variables, words[2]);
								if(index2==-1) {
									try {
										variables.get(index).setValue(variables.get(index).getValue()-Double.parseDouble(words[2]));
									}
									catch(NumberFormatException e) {
										System.out.println("Error operand2 is not a number and is not a variable: line " + numberLine);
										return;
									}
								}
								else {
									variables.add(index,Sub.getVariable(variables.get(index), variables.get(index2)));
								}
							}
							break;
						case Mul.Name:
							if(index==-1) {
								System.out.println("Error operand1 unknown variable: line " + numberLine);
								return;
							}
							else {
								int index2=WorkListVariables.getIndex(variables, words[2]);
								if(index2==-1) {
									try {
										variables.get(index).setValue(variables.get(index).getValue()*Double.parseDouble(words[2]));
									}
									catch(NumberFormatException e) {
										System.out.println("Error operand2 is not a number and is not a variable: line " + numberLine);
										return;
									}
								}
								else {
									variables.add(index,Mul.getVariable(variables.get(index), variables.get(index2)));
								}
							}
							break;
						case Div.Name:
							if(index==-1) {
								System.out.println("Error operand1 unknown variable: line " + numberLine);
								return;
							}
							else {
								int index2=WorkListVariables.getIndex(variables, words[2]);
								if(index2==-1) {
									try {
										variables.get(index).setValue(variables.get(index).getValue()/Double.parseDouble(words[2]));
									}
									catch(NumberFormatException e) {
										System.out.println("Error operand2 is not a number and is not a variable: line " + numberLine);
										return;
									}
								}
								else {
									variables.add(index,Div.getVariable(variables.get(index), variables.get(index2)));
								}
							}
							break;
						case Cmp.Name:
							int index2=WorkListVariables.getIndex(variables, words[2]);
							if(index==-1) {
								Variable a=new Variable();
								try {
									a.setValue(Double.parseDouble(words[1]));
								}
								catch(NumberFormatException e) {
									System.out.println("Error operand1 is not a number and is not a variable: line " + numberLine);
									return;
								}
								if(index2==-1) {
									Variable b=new Variable();
									try {
										b.setValue(Double.parseDouble(words[2]));
									}
									catch(NumberFormatException e) {
										System.out.println("Error operand2 is not a number and is not a variable: line " + numberLine);
										return;
									}
									specvar=Cmp.getSpecVar(a, b);
								}
								else {
									specvar=Cmp.getSpecVar(a, variables.get(index2));
								}
							}
							else {
								if(index2==-1) {
									Variable b=new Variable();
									try {
										b.setValue(Double.parseDouble(words[2]));
									}
									catch(NumberFormatException e) {
										System.out.println("Error operand2 is not a number and is not a variable: line " + numberLine);
										return;
									}
									specvar=Cmp.getSpecVar(variables.get(index), b);
								}
								else {
									specvar=Cmp.getSpecVar(variables.get(index), variables.get(index2));
								}
							}
							break;
						default:
							System.out.println("Error command: line " + numberLine);
							return;
					}
				}
				else {
					System.out.println("Error: line " + numberLine);
					break;
				}
				line = reader.readLine();
				numberLine += 1;
			}
		}
		catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
