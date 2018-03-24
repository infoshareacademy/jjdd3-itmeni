<div class="weather-margin">

<h3>Weather forecast for Gdansk in next 24 hours.</h3>
<br>
</div>
<div class="weather-margin-list">
<#list weather>

    <#items as weatherComponentsInList>

        ${weatherComponentsInList}<#sep><br></#sep>

    </#items>
</#list>

</div>
