<template>
    <div>
        <i>({{ contact.id }})</i> {{ contact.text }}
        <span style="position: absolute; right: 0">
            <input type="button" value="Edit" @click="edit" />
            <input type="button" value="X" @click="del" />
        </span>
    </div>
</template>

<script>
    export default {
        props: ['contact', 'editContact', 'deleteContact', 'contacts'],
        methods: {
            edit() {
                this.editContact(this.contact)
            },
            del() {
                this.deleteContact(this.contact)
            }
        }
    }
</script>

<style>

</style>
