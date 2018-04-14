grammar Mlang;

program
    : (variableDecl | functionDecl | classDecl) *
    ;

classDecl
    : CLASS ID '{' (functionDecl | variableDecl)* '}'
    ;

functionDecl
    : type? ID '('(parameter (','parameter)*)?')' block
    ;

variableDecl
    : type ID '=' expression';'
    | type ID ';'
    ;

parameter 
    : type ID
    ;


builtInType
    : BOOL | INT | STRING | VOID
    ;

userType : ID;

type
    : (builtInType | userType) ('['']')*
    ;

block
    : '{' statement* '}'
    ;

statement
    : block
    | variableDecl
    | IF '('expression')' statement (ELSE statement)?
    | FOR '('init=expression? ';' cond=expression?';' update=expression?')' statement
    | WHILE '('expression ')' statement
    | RETURN '(' expression ')' ';'
    | BREAK ';'
    | CONTINUE ';'
    | expression ';'
    | ';'
    ;

actual_parameter
    : expression (',' expression)*
    ;

expression 
    : expression '.' ID
    | expression '[' expression ']'
    | expression op=('++'|'--')
    | ID '(' actual_parameter ')'
    | op=('++'|'--') expression
    | op=('+'|'-') expression
    | op=('!'|'~') expression
    | NEW type (('['expression']')+ ('[]')*)?
    | expression op=('*'|'/'|'%') expression
    | expression op=('+'|'-') expression
    | expression op=('<<'|'>>') expression
    | expression op=('<'|'<='|'>'|'>=') expression
    | expression op=('=='|'!=') expression
    | expression '&' expression
    | expression '^' expression
    | expression '|' expression
    | expression '&&' expression
    | expression '||' expression
    | NUM
    | TRUE
    | FALSE
    | NULL
    | STR
    | ID
    | '(' expression ')'
    | THIS
    | expression '=' expression
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

COMMENT : '//';
MUL     : '*';
DIV     : '/';
ADD     : '+';
SUB     : '-';

ID      : [a-zA-Z]+[a-zA-Z_]*;
WS      : [ \t\n\r]+ -> skip;