grammar Mlang;

program
    : (variableDecl | functionDecl | classDecl) *
    ;

classDecl
    : CLASS ID '{' (functionDecl | variableDecl)* '}'
    ;

functionDecl
    : type? ID '('formal_parameter?')' block
    ;

statement
    : block                                                     #blockStat
    | variableDecl                                              #varDeclStat
    | IF '('expression')' statement (ELSE statement)?           #ifStat
    | FOR '('init=expression?';'
             cond=expression?';'
             update=expression?')' statement                    #forStat
    | WHILE '('expression ')' statement                         #whileStat
    | RETURN expression';'                                      #returnStat
    | BREAK ';'                                                 #breakStat
    | CONTINUE ';'                                              #continueStat
    | expression ';'                                            #exprStat
    | ';'                                                       #emptyStat
    ;

variableDecl
    : type ID '=' expression';'
    | type ID ';'
    ;

parameter 
    : type ID
    ;

formal_parameter
    : parameter (','parameter)*
    ;


builtInType
    : BOOL | INT | STRING | VOID
    ;

userType : ID;
arrayType : (builtInType | userType) ('[]')+;

type
    : (arrayType | builtInType | userType)
    ;

block
    : '{' statement* '}'
    ;


actual_parameter
    : expression (',' expression)*
    ;

expression 
    : expression '.' expression                                 #memberExpr
    | expression '[' expression ']'                             #arrayExpr
    | expression op=('++'|'--')                                 #suffixExpr
    | ID '(' actual_parameter? ')'                              #callExpr
    | op=('++'|'--') expression                                 #prefixExpr
    | op=('+'|'-') expression                                   #prefixExpr
    | op=('!'|'~') expression                                   #prefixExpr
    | NEW type (('['expression']')+ ('[]')*)?                   #newExpr
    | expression op=('*'|'/'|'%') expression                    #binaryExpr
    | expression op=('+'|'-') expression                        #binaryExpr
    | expression op=('<<'|'>>') expression                      #binaryExpr
    | expression op=('<'|'<='|'>'|'>=') expression              #binaryExpr
    | expression op=('=='|'!=') expression                      #binaryExpr
    | expression '&' expression                                 #binaryExpr
    | expression '^' expression                                 #binaryExpr
    | expression '|' expression                                 #binaryExpr
    | expression '&&' expression                                #andExpr
    | expression '||' expression                                #orExpr
    | NUM                                                       #intConstExpr
    | TRUE                                                      #boolConstExpr
    | FALSE                                                     #boolConstExpr
    | NULL                                                      #nullExpr
    | STR                                                       #stringConstExpr
    | ID                                                        #idExpr
    | '(' expression ')'                                        #subExpr
    | THIS                                                      #thisExpr
    | expression '=' expression                                 #assignExpr
    ;


BOOL    : 'bool';
INT     : 'int';
STRING  : 'string';
NULL    : 'null';
VOID    : 'void';

TRUE    : 'true';
FALSE   : 'false';
IF      : 'if';
ELSE    : 'else';
FOR     : 'for';
WHILE   : 'while';

BREAK   : 'break';
CONTINUE   : 'continue';
RETURN   : 'return';

NEW     : 'new';
CLASS   : 'class';
THIS    : 'this';

NUM     : [0-9]+;
ESC     : '\\"' | '\\\\' | '\\n';
STR     : '"'(ESC|.)*?'"';

COMMENT :  '//' ~[\r\n]* -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;
MUL     : '*';
DIV     : '/';
ADD     : '+';
SUB     : '-';

ID      : [a-zA-Z]+[a-zA-Z_0-9]*;
WS      : [ \t\n\r]+ -> skip;
