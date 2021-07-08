// Game Description Language (GDL) in KIF prefix style
// does not handle extraneous parentheses
grammar GDL;

description : clause* ;

clause
    : grule
    | fact
    ;

grule : '(<=' head condition+ ')' ;

fact
    : '(' INIT predicate ')'    # init
    | '(' ROLE CONST ')'        # role
    | head                      # customFact
    ;

head
    : '(' NEXT predicate ')'        # next
    | '(' LEGAL atom arg ')'        # legal
    | '(' GOAL atom atom ')'        # goal
    | '(' BASE predicate ')'        # base
    | '(' INPUT atom predicate ')'  # input
    | TERMINAL                      # terminal
    | predicate                     # customRule
    ;

condition
    : '(' ROLE atom ')'
    | '(' TRUE predicate ')'
    | '(' NOT condition ')'
    | '(' OR condition condition+ ')'
    | '(' DISTINCT atom atom ')'
    | '(' DOES atom arg ')'
    | predicate
    ;

predicate
    : CONST
    | '(' CONST atom+ ')'
    ;

arg
    : atom
    | predicate
    ;

atom
    : CONST
    | VAR
    ;

INIT        : 'init' ;
BASE        : 'base' ;
INPUT       : 'input' ;
ROLE        : 'role' ;
GOAL        : 'goal' ;
NEXT        : 'next' ;
TERMINAL    : 'terminal' ;
LEGAL       : 'legal' ;
NOT         : 'not' ;
TRUE        : 'true' ;
OR          : 'or' ;
DISTINCT    : 'distinct' ;
DOES        : 'does' ;
CONST       : [a-zA-Z0-9_]+ ;
VAR         : '?' [a-zA-Z0-9_]+ ;
COMMENT     : ';' .*? '\r'? '\n' -> skip ; // skip comments
WS          : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
