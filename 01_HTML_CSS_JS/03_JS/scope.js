let globalVal = 1;
for (let i = 0; i < 2; i++) {}
function f() {
  let localValue = 1;
  console.log(`in o() localValue = ${localValue}`);
}
f(); //in o() localValue = 1

function o() {
  let oValue = 'oValue';
  function i() {
    let iValue = 'iValue';
    console.log(`in i() iValue=${iValue}, oValue=${oValue}`);
  }
  console.log(`in o() oValue=${oValue}`);
  i(); //in i() iValue=iValue, oValue=oValue
  // console.log(`in o() iValue=${iValue}`) //X
}
o(); //in o() oValue=oValue

function r() {
  let oValue = 'oValue';
  let own = 'outer';
  let oCnt = 0;
  console.log(`in r() oValue=${oValue}, own=${own}`);
  return function () {
    let iValue = 'iValue';
    let own = 'inner';
    let iCnt = 0;
    oCnt++;
    iCnt++;
    console.log(
      `in return함수() iValue=${iValue}, oValue=${oValue} own=${own}, oCnt=${oCnt}, iCnt=${iCnt}`
    );
  };
}
let rReturn = r(); //in r() oValue=oValue, own=outer
rReturn(); //in return함수() iValue=iValue, oValue=oValue own=inner
rReturn();
r()();
r()();
