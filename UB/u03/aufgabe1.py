class Parser(object):
    def __init__(self, input):
        self.input = input
        self.lookahead_idx = 0
        self.S()
    
    def lookahead(self):
        return self.input[self.lookahead_idx]

    def match(self, terminal):
        if terminal == self.lookahead():
            self.lookahead_idx += 1
            if self.lookahead_idx >= len(self.input):
                # make lookahead stop at the end of input
                self.lookahead_idx = len(self.input)-1
        else:
            raise SyntaxError(
                    "syntax error '%s', expected '%s'" %
                        (self.lookahead(), terminal)
                )
    
# I don't allways Yoda-compare, but when I do it serves clearness.
class ParserA(Parser):
    def S(self):
        if   '+' == self.lookahead():
            self.match('+')
            self.S()
            self.S()
        elif '-' == self.lookahead():
            self.match('-')
            self.S()
            self.S()
        elif 'a' == self.lookahead():
            self.match('a')
        else:
            raise SyntaxError(
                    "syntax error: no rule for '%s'" %
                        self.lookahead()
                )

class ParserB(Parser):
    def S(self):
        if   '(' == self.lookahead():
            self.match('(')
            self.S()
            self.match(')')
            self.S()

class ParserC(Parser):
    def E(self):
        if   '0' == self.lookahead():
            self.match('0')
            self.E()
            self.match('1')
        elif '1' == self.lookahead():
            self.match('1')
        else:
            raise SyntaxError(
                    "syntax error: no rule for '%s'" %
                        self.lookahead()
                )

    def S(self):
        if   '0' == self.lookahead():
            self.match('0')
            self.E()
        else:
            raise SyntaxError(
                    "syntax error: no rule for '%s'" %
                        self.lookahead()
                )

class ParserRoman(Parser):
    def T(self):
        if '0' == self.lookahead():
            self.match('0')
        elif '1' == self.lookahead():
            self.match('1')
            print 'M',
        elif '2' == self.lookahead():
            self.match('2')
            print 'MM',
        elif '3' == self.lookahead():
            self.match('3')
            print 'MMM',
        elif '4' == self.lookahead():
            self.match('4')
            print 'MMMM',
        elif '5' == self.lookahead():
            self.match('5')
            print 'MMMMM',
        elif '6' == self.lookahead():
            self.match('6')
            print 'MMMMMM',
        elif '7' == self.lookahead():
            self.match('7')
            print 'MMMMMMM',
        elif '8' == self.lookahead():
            self.match('8')
            print 'MMMMMMMM',
        elif '9' == self.lookahead():
            self.match('9')
            print 'MMMMMMMMM',

    def H(self):
        if '0' == self.lookahead():
            self.match('0')
        elif '1' == self.lookahead():
            self.match('1')
            print 'C',
        elif '2' == self.lookahead():
            self.match('2')
            print 'CC',
        elif '3' == self.lookahead():
            self.match('3')
            print 'CCC',
        elif '4' == self.lookahead():
            self.match('4')
            print 'CD',
        elif '5' == self.lookahead():
            self.match('5')
            print 'D',
        elif '6' == self.lookahead():
            self.match('6')
            print 'DC',
        elif '7' == self.lookahead():
            self.match('7')
            print 'DCC',
        elif '8' == self.lookahead():
            self.match('8')
            print 'DCCC',
        elif '9' == self.lookahead():
            self.match('9')
            print 'CM',

    def Z(self):
        if '0' == self.lookahead():
            self.match('0')
        elif '1' == self.lookahead():
            self.match('1')
            print 'X',
        elif '2' == self.lookahead():
            self.match('2')
            print 'XX',
        elif '3' == self.lookahead():
            self.match('3')
            print 'XXX',
        elif '4' == self.lookahead():
            self.match('4')
            print 'XL',
        elif '5' == self.lookahead():
            self.match('5')
            print 'L',
        elif '6' == self.lookahead():
            self.match('6')
            print 'LX',
        elif '7' == self.lookahead():
            self.match('7')
            print 'LXX',
        elif '8' == self.lookahead():
            self.match('8')
            print 'LXXX',
        elif '9' == self.lookahead():
            self.match('9')
            print 'XC',

    def E(self):
        if '0' == self.lookahead():
            self.match('0')
        elif '1' == self.lookahead():
            self.match('1')
            print 'I',
        elif '2' == self.lookahead():
            self.match('2')
            print 'II',
        elif '3' == self.lookahead():
            self.match('3')
            print 'III',
        elif '4' == self.lookahead():
            self.match('4')
            print 'II',
        elif '5' == self.lookahead():
            self.match('5')
            print 'V',
        elif '6' == self.lookahead():
            self.match('6')
            print 'VI',
        elif '7' == self.lookahead():
            self.match('7')
            print 'VII',
        elif '8' == self.lookahead():
            self.match('8')
            print 'VIII',
        elif '9' == self.lookahead():
            self.match('9')
            print 'IX',

    def S(self):
        self.T()
        self.H()
        self.Z()
        self.E()

if __name__ == "__main__":
    import sys
    ParserRoman(sys.argv[1])
    print
