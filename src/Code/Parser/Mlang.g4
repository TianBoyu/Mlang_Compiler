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
    | RETURN expression?';'                                     #returnStat
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

arrayType : (builtInType | userType) (LBRAC RBRAC)+;
builtInType
    : BOOL | INT | STRING | VOID
    ;

userType : ID;

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
    : expression '.' (ID | functionCall)                        #memberExpr
    | expression '[' expression ']'                             #arrayExpr
    | expression op=('++'|'--')                                 #suffixExpr
    | functionCall                                              #callExpr
    | op=('++'|'--') expression                                 #prefixExpr
    | op=('+'|'-') expression                                   #prefixExpr
    | op=('!'|'~') expression                                   #prefixExpr
    | NEW creator'(' ')'                                        #newExpr
    | expression op=('*'|'/'|'%') expression                    #binaryExpr
    | expression op=('+'|'-') expression                        #binaryExpr
    | expression op=('<<'|'>>') expression                      #binaryExpr
    | expression op=('<'|'<='|'>'|'>=') expression              #binaryExpr
    | expression op=('=='|'!=') expression                      #binaryExpr
    | expression op='&' expression                              #binaryExpr
    | expression op='^' expression                              #binaryExpr
    | expression op='|' expression                              #binaryExpr
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


creator
    : (userType | builtInType) ('[' expression ']')* (LBRAC RBRAC)+ ('['expression']')+ #wrongCreator
    | (userType | builtInType) ('[' expression ']')+ (LBRAC RBRAC)*                    #arrayCreator
    | userType                                                                     #nonArrayCreator
    ;

functionCall
    : ID '(' actual_parameter? ')'
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

LBRAC   : '[';
RBRAC   : ']';

ID      : [a-zA-Z]+[a-zA-Z_0-9]*;
WS      : [ \t\n\r]+ -> skip;
