grammar Mlang;

prog: (func_def | class_def | var_dec)+;


class_def: CLASS id '{'prog'}';
func_def: class_type id '('stat_list')''{'stat'}';
var_dec: class_type assign_expr ';'
       | class_type ID
       ;

stat: decl_stat | expr_stat
    | cond_stat | circ_stat | jump_stat;
cond_stat: IF '(' expr ')' stat
         | IF '(' expr ')' stat ELSE stat;
circ_stat: FOR '(' expr? ';' expr? ';' expr? ')' stat
         | WHILE '(' expr ')' stat;
jump_stat: RETURN expr? ';'
         | BREAK ';'
         | CONTI ';'
         ;
expr_stat: expr';';
decl_stat: var_dec;

//expr: unary_expr | binary_expr | name_expr | assign_expr;
//unary_expr: expr ('++'|'--')
//         | id '('expr_list ')'
//         | ('++'|'--') expr
//         | ('+' | '-') expr
//         | ('!' | '~') expr
//         | NEW class_id (('['expr']')+ ('[]')*)?
//         ;
//binary_expr: expr('*'|'/'|'%')expr
//         | expr('+'|'-')expr
//         | expr('>>'|'<<')expr
//         | expr('<'|'<='|'>'|'>=')expr
//         | expr('=='|'!=')expr
//         | expr('&')expr
//         | expr('^')expr
//         | expr('|')expr
//         | expr('&&')expr
//         | expr('||')expr
expr:      expr op=('++'|'--')
         | id '(' expr_list ')'
         | op=('++'|'--') expr
         | op=('+'|'-') expr
         | op=('!'|'~') expr
         | NEW class_id (('['expr']')+ ('[]')*)?
         | expr op=('*'|'/'|'%') expr
         | expr op=('+'|'-') expr
         | expr op=('<<'|'>>') expr
         | expr op=('<'|'<='|'>'|'>=') expr
         | expr op=('=='|'!=') expr
         | expr '&' expr
         | expr '^' expr
         | expr '|' expr
         | expr '&&' expr
         | expr '||' expr
         | NUM
         | TRUE
         | FALSE
         | NULL
         | STR
         | id
         | '(' expr ')'
         | assign_expr
         ;

expr_list: expr_list ',' expr
         | expr?
         ;
stat_list: stat_list ',' class_id id
         | (class_id id)?
         ;
assign_expr: id '=' expr;

id: ID
  | id '[' expr ']'
  | id '.' id
  ;

class_id: BOOL
        | INT
        | STRING
        | VOID
        | ID
        ;
class_type: class_id '[]'*;


//reserved Keywords
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
CONTI   : 'continue';
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
//NAME : [a-zA-Z_]+ ;
WS      : [ \t\n\r]+ -> skip;



