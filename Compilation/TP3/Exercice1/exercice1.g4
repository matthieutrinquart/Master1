grammar Exercice1;

int : 'integer';
bool :'boolean';
arrayof : 'array of';


type : int|bool|arrayof;



const : [0-9]*|true|false;


uop :'-'|'not';



bop : '+' | '-' | '*' | '/'| 'and' | 'or'| '<' | '<=' | '='| '!=' | '>=' | '>'

WS : [ \t\r\n]+ -> skip ;



