// Game Description Language (GDL) in KIF prefix style
grammar GDL;

description
    : (gdlRule | comment)*
    ;

gdlRule
    : '(<=' literal+ ')'
    | literal
    ;

comment
    : COMMENT;

literal
    : '(' literal ')'
    | notLiteral
    | orLiteral
    | distinctLiteral
    | propositionLiteral
    | relationLiteral
    ;

notLiteral
    : 'not' literal
    ;

orLiteral
    : 'or' literal literal+
    ;

distinctLiteral
    : 'distinct' term term
    ;

propositionLiteral
    : CONST
    ;

relationLiteral
    : CONST term+
    ;

term
    : '(' term ')'
    | var 
    | CONST
    | relationLiteral
    ;

var
    : '?' CONST
    ;

CONST       : [a-zA-Z0-9_]+ ;
COMMENT     : ';' .*? '\r'? '\n' -> skip ; // skip comments
WS          : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
