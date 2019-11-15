<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="SelectCollect"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchA2B():V"/>
		<constant value="__exec__"/>
		<constant value="A2B"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyA2B(NTransientLink;):V"/>
		<constant value="__matchA2B"/>
		<constant value="Model"/>
		<constant value="ABCD"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="a"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="b"/>
		<constant value="WXYZ"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="23:3-25:4"/>
		<constant value="__applyA2B"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="J.getAs():J"/>
		<constant value="J.first():J"/>
		<constant value="24:12-24:22"/>
		<constant value="24:12-24:30"/>
		<constant value="24:12-24:39"/>
		<constant value="24:4-24:39"/>
		<constant value="link"/>
		<constant value="getAs"/>
		<constant value="J.allInstances():J"/>
		<constant value="J.&lt;&gt;(J):J"/>
		<constant value="B.not():B"/>
		<constant value="23"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="c"/>
		<constant value="34"/>
		<constant value="anIntegerAttr"/>
		<constant value="0"/>
		<constant value="J.&gt;(J):J"/>
		<constant value="47"/>
		<constant value="QJ.first():J"/>
		<constant value="49"/>
		<constant value="28:43-28:49"/>
		<constant value="28:43-28:64"/>
		<constant value="29:18-29:19"/>
		<constant value="29:18-29:24"/>
		<constant value="29:28-29:31"/>
		<constant value="29:18-29:31"/>
		<constant value="28:43-29:32"/>
		<constant value="30:18-30:19"/>
		<constant value="30:18-30:24"/>
		<constant value="30:28-30:31"/>
		<constant value="30:18-30:31"/>
		<constant value="28:43-30:32"/>
		<constant value="31:22-31:23"/>
		<constant value="31:22-31:37"/>
		<constant value="31:40-31:41"/>
		<constant value="31:22-31:41"/>
		<constant value="31:59-31:71"/>
		<constant value="31:47-31:48"/>
		<constant value="31:47-31:53"/>
		<constant value="31:19-31:77"/>
		<constant value="28:43-31:78"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="46"/>
			<push arg="47"/>
			<findme/>
			<push arg="48"/>
			<call arg="49"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="50"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="51"/>
			<dup/>
			<push arg="52"/>
			<load arg="19"/>
			<pcall arg="53"/>
			<dup/>
			<push arg="54"/>
			<push arg="46"/>
			<push arg="55"/>
			<new/>
			<pcall arg="56"/>
			<pusht/>
			<pcall arg="57"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="58" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="52" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="59">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="60"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="52"/>
			<call arg="61"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="54"/>
			<call arg="62"/>
			<store arg="63"/>
			<load arg="63"/>
			<dup/>
			<getasm/>
			<getasm/>
			<call arg="64"/>
			<call arg="65"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="66" begin="11" end="11"/>
			<lne id="67" begin="11" end="12"/>
			<lne id="68" begin="11" end="13"/>
			<lne id="69" begin="9" end="15"/>
			<lne id="58" begin="8" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="54" begin="7" end="16"/>
			<lve slot="2" name="52" begin="3" end="16"/>
			<lve slot="0" name="17" begin="0" end="16"/>
			<lve slot="1" name="70" begin="0" end="16"/>
		</localvariabletable>
	</operation>
	<operation name="71">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="6"/>
			<push arg="47"/>
			<findme/>
			<call arg="72"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="38"/>
			<push arg="54"/>
			<call arg="73"/>
			<call arg="74"/>
			<if arg="75"/>
			<load arg="19"/>
			<call arg="76"/>
			<enditerate/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="38"/>
			<push arg="77"/>
			<call arg="73"/>
			<call arg="74"/>
			<if arg="78"/>
			<load arg="19"/>
			<call arg="76"/>
			<enditerate/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="79"/>
			<pushi arg="80"/>
			<call arg="81"/>
			<if arg="82"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<call arg="83"/>
			<goto arg="84"/>
			<load arg="19"/>
			<get arg="38"/>
			<call arg="76"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="85" begin="9" end="11"/>
			<lne id="86" begin="9" end="12"/>
			<lne id="87" begin="15" end="15"/>
			<lne id="88" begin="15" end="16"/>
			<lne id="89" begin="17" end="17"/>
			<lne id="90" begin="15" end="18"/>
			<lne id="91" begin="6" end="23"/>
			<lne id="92" begin="26" end="26"/>
			<lne id="93" begin="26" end="27"/>
			<lne id="94" begin="28" end="28"/>
			<lne id="95" begin="26" end="29"/>
			<lne id="96" begin="3" end="34"/>
			<lne id="97" begin="37" end="37"/>
			<lne id="98" begin="37" end="38"/>
			<lne id="99" begin="39" end="39"/>
			<lne id="100" begin="37" end="40"/>
			<lne id="101" begin="42" end="45"/>
			<lne id="102" begin="47" end="47"/>
			<lne id="103" begin="47" end="48"/>
			<lne id="104" begin="37" end="48"/>
			<lne id="105" begin="0" end="50"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="52" begin="14" end="22"/>
			<lve slot="1" name="52" begin="25" end="33"/>
			<lve slot="1" name="52" begin="36" end="49"/>
			<lve slot="0" name="17" begin="0" end="50"/>
		</localvariabletable>
	</operation>
</asm>
